from jupyter_dash import JupyterDash

import dash_leaflet as dl
from dash import dcc
from dash import html
import plotly.express as px
from dash import dash_table
from dash.dependencies import Input, Output, State
import base64
import re


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

import AAC
from AAC import AnimalShelter
#load data from csv file
try:
    df = pd.read_csv('aac_shelter_outcomes.csv', index_col=0)
    animal_id_index = df.columns.get_loc('animal_id')
    df = df.astype(str)
    df.insert(animal_id_index, 'count_down_column', df.index.astype(str))
    unnamed_column = df.pop(df.columns[0])
    df.insert(0, 'unnamed_column', unnamed_column)
except FileNotFoundError:
    df = pd.DataFrame()

def create_regex(keyword):
    return re.compile('.*' + '.*|.*'.join(keyword) + '.*', re.IGNORECASE)

def filter_data(shelter, breed, sex, min_age, max_age):
    query = {"$or": [{"breed": {"$regex": create_regex(breed)}}]}
    if sex is not None:
        query["sex_upon_outcome"] = sex
    query["age_upon_outcome_in_weeks"] = {"$gte": min_age, "$lte": max_age}
    return pd.DataFrame.from_records(shelter.query(**query))



app = JupyterDash(__name__)
username = "aacuser"
password = "password"
# Connect to database via CRUD Module
db = AnimalShelter(username, password)
df = pd.DataFrame.from_records(app.find({}, projection={'_id': 0}))

#Add in Grazioso Salvare’s logo
image_filename = 'Grazioso_Salvare_Logo.png'
encoded_image = base64.b64encode(open(image_filename, 'rb').read())

app.layout = html.Div([
    html.A([
        html.Center(html.Img(src='data:image/png;base64,{}'.format(encoded_image.decode()),
            height = 250, width = 251))], href = 'https://www.snhu.edu', target = '_blank'),
    html.Center(html.B(html.H2('CS-499 Artifact Three Enhancement'))),
    html.Center(html.B(html.H6('By: ShiAnn Rule'))),
    html.Hr(),
    html.Div(
        dcc.RadioItems(
            id='filter_type',
            options=[{'label': 'Reset', 'value': 'Reset'},
                     {'label':'Water Rescue', 'value': 'Water'},
                     {'label':'Mountain or Wilderness Rescue', 'value': 'Mountain'},
                     {'label':'Disaster Rescue or Individual Tracking', 'value': 'Disaster'},
                    ],
            value='Reset'
        )),

    html.Div([
        html.H3('Add New Animal', style={'textAlign': 'center'}),
        dcc.Input(id='new-animal-name', type='text', placeholder='Name'),
        dcc.Input(id='new-animal-breed', type='text', placeholder='Breed'),
        dcc.Input(id='new-animal-age', type='text', placeholder='Age'),
        dcc.Input(id='new-animal-sex', type='text', placeholder='Sex'),
        dcc.Input(id='new-animal-id', type='text', placeholder='ID'),
        html.Div(id='debug-output'),
        html.Button('Add Animal', id='add_animal_button', n_clicks=0, disabled=True),
    ],
    style={'width': '100%', 'display': 'inline-block', 'margin': 'auto', 'textAlign': 'center'}),

    html.Hr(),
    dash_table.DataTable(
        id='datatable-id',
        columns=[{"name": i, "id": i, "deletable": False, "selectable": True} for i in df.columns],
        data=df.to_dict('records'),
        editable=True,
        filter_action="native", #allows filter
        row_selectable="single", #single row selectable,cannot allow multi row
        selected_rows=[1], #no default selected row
        sort_action="native", #enable sorting
        page_action="native", #enable pagination
        page_size=10, #limit displayed rows on page
                        ),
    html.Br(),
    html.Hr(),
#This sets up the dashboard so that your chart and your geolocation chart are side-by-side
    html.Div(className='row',
         style={'display' : 'flex'},
             children=[
        html.Div([
            dcc.Dropdown(
            id='pie_chart',
            className='col s12 m6',
            options=[
                {'label': 'Breed', 'value': 'breed'},
                {'label': 'Age', 'value': 'age_upon_outcome'},
                {'label': 'Outcome Type', 'value': 'outcome_type'},
            ],
            value='breed',
            multi=False,
            clearable=False
            )],
            #style={"width":"20%"}
        ),

        html.Div(
            id='graph-id',
            className='col s12 m6',
        ),
        html.Div(
            id='map-id',
            className='col s12 m6',
            )
        ]),
    html.H6('By: ShiAnn Rule')
])

def add_animal_button(n_clicks, auth_status, name, breed, age, sex, id):
    data = {name, breed, age, sex, id}
    if auth_status is not None:
        return '', '', '', '', '', False
    else:
        AAC.AnimalShelter.create(n_clicks, data)
        return '', '', '', '', '', True

filter_criteria = {
    'All': {
    'breed' : [],
    'sex': None,
    'min_age': 0.0,
    'max_age': 9999.0,
    },
    'Mountain': {
        'breed' : {"$in":["German Sheperd", "Alaskan Malamute", "Old English Sheepdog", "Siberian Husky","Rottweiler"]},
        'sex' : "Intact Male",
        'min_age': {"$gte":26},
        'max_age': {"$lte":156}

    },
    'Water':{
        'breed' : {"$in":["Labrador Retriever Mix", "Chesapeake Bay Retriever", "Newfoundland"]},
        'sex' : "Intact Female",
        'min_age' : {"$gte":26},
        'max_age': {"$lte":156}
    },
    'Disaster': {
        'breed' : {"$in":["Doberman Pinscher", "German Shepherd", "Golden Retriever", "Bloodhound","Rottweiler"]},
        'sex' : "Intact Male",
        'min_age' : {"$gte":26},
        'max_age': {"$lte":300}
    }

}

@app.callback([Output('datatable-id','data'),
              Output('datatable-id', 'columns')],
              [Input('filter_type', 'value')])
def update_dashboard(filter_type):
    print(f"selected filter: {filter_type}")
    criteria = filter_criteria.get(filter_type, filter_criteria['All'])
    df = filter_data(db, **criteria)
    columns=[{"name": i, "id": i, "deletable": False, "selectable": True} for i in df.columns]
    data = df.to_dict('records')
    return (data,columns)

@app.callback(
    Output('graph-id', "children"),
    [Input('datatable-id', "derived_virtual_data"),
    Input('pie_chart', 'value')])
def update_graphs(viewData, dropdown_value):
    dff = pd.DataFrame.from_dict(viewData)
    return [
        dcc.Graph(
            figure = px.pie(data_frame=dff,names=dropdown_value,title='Preferred Animals')
        )
    ]

#This callback will highlight a cell on the data table when the user selects it
@app.callback(
    Output('datatable-id', 'style_data_conditional'),
    [Input('datatable-id', 'selected_columns')]
)
def update_styles(selected_columns):
    return [{
        'if': { 'column_id': i },
        'background_color': '#D2F3FF'
    } for i in selected_columns]


# This callback will update the geo-location chart for the selected data entry
@app.callback(
    Output('map-id', "children"),
    [Input('datatable-id', "derived_virtual_data"),
     Input('datatable-id', "derived_virtual_selected_rows")])
def update_map(viewData, index):
    if viewData is None:
        return
    elif index is None:
        return

    dff = pd.DataFrame.from_dict(viewData)
    # Because we only allow single row selection, the list can be converted to a row index here
    if index is None:
        row = 0
    else:
        row = index[0]

    # Austin TX is at [30.75,-97.48]
    return [
        dl.Map(style={'width': '1000px', 'height': '500px'}, center=[30.75,-97.48], zoom=10, children=[
            dl.TileLayer(id="base-layer-id"),
            # Marker with tool tip and popup
            # Column 13 and 14 define the grid-coordinates for the map
            # Column 4 defines the breed for the animal
            # Column 9 defines the name of the animal
            dl.Marker(position=[dff.iloc[row,13],dff.iloc[row,14]], children=[
                dl.Tooltip(dff.iloc[row,4]),
                dl.Popup([
                    html.H1("Animal Name"),
                    html.P(dff.iloc[row,9])
                ])
            ])
        ])
    ]



app.run_server(debug=True)
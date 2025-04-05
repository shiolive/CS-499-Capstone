## CS-499 ePortfolio for ShiAnn Rule

### Introduction

Hello, my name is ShiAnn Rule and I have been in SNHU's Computer Science degree program since August 2021. This page is my final project for CS-499 Capstone and marks my completion of my Bachelor's degreee in Computer Science. 

### Course Outcomes

List course outcomes represented

### Professional Self Assessment

Professional Self assessment here

### Informal Code Review

Overview of Code Review

<iframe width="1252" height="704" src="https://www.youtube.com/embed/S8QaOK-XVL4" title="CS-499 Code Review" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

### Enhancement One: Software Design and Engineering

This artifact is a weight tracking application created in Android Studio utilizing Java for the base, XML for the UI, and SQLite for the database. It is an android application that allows a user to log their weight to track their weight over time, set a goal, receive notifications, and view their data in multiple ways. It was originally created in October 2024 for the SNHU CS-360 Mobile Architecture course. I selected this item because it is a full stack mobile application that I will be able to make significant improvements on and will be able to show my software engineering and design skills comprehensively.  

The main area that I chose to focus on to showcase my skills was the main activity of the application. In the main activity, the user has the option to add their weight and the date, and it displays the weight history in a grid format. This part of the application needed many improvements to make it more user-friendly and helpful. I swapped out the grid display of the weight history for a graph display which makes the data easier to view at a glance. I also made the date field auto generate for the current date so that the user doesn't have to enter the date themselves. This also allowed me to have better data so the graph could function properly. I moved the grid format to a separate page and added a button so the user could go view that information if they would like to. The final improvement I made was to create a check against the user’s goal weight each time they enter an updated weight. If they met or surpassed their goal, the app displays a congratulatory message letting them know that they reached their goal.  

The process of improving this application ended up being much more difficult than I anticipated. The biggest challenge was getting the graph set up. The resources that I could find online to educate myself on the GraphView library were limited. The primary challenge with setting up the graph was being able to have the X axis be dates and have them populate correctly with the corresponding data. It required me to rethink how a significant portion of my main activity and database operated and ended up requiring me to rebuild a significant portion of the way that it worked. I ended up finding it necessary to populate the date for the user which required me to also adjust how records were added to the database. Overall, with the research I was able to find and trying different techniques and troubleshooting them until I found what worked for my project, I was able to overcome this challenge and my application ended up better for it. 

[Link to Artifact One Repository](https://github.com/shiolive/CS-499/tree/main/Artifacts/Artifact%20One/Artifact%20One%20Improvement)


### Enhancement Two: Algorithms and Data Structures

Overview

Link to resource


### Enhancement Three: Databases

Overvview

Link to resource


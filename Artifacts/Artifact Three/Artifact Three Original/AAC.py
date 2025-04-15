#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul 28 21:12:04 2024

@author: shiannoliver_snhu
"""

from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    def __init__(self, inputUser, inputPass):
        self.USER = inputUser
        self.PASS = inputPass
        self.HOST = 'nv-desktop-services.apporto.com'
        self.PORT = 32646
        self.DB = 'AAC'
        self.COL = 'animals'
        
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (self.USER,self.PASS,self.HOST,self.PORT))
        self.database = self.client['%s' % (self.DB)]
        self.collection = self.database['%s' % (self.COL)]
                
    def create(self, data):
        if data is not None:
            self.database.animals.insert(data)
            return True
        else:
            raise Exception("Nothing to save, data parameter is empty")
            return False
            
    def read(self, query):
        if query is not None:
            cursor = self.collection.find(query)
            result = [doc for doc in cursor]
            return result
            #data = self.database.animals.find(query, {"_id": False})
            #for document in data:
            #    print(document)
        else:
            raise Exception("Query parameter empty")
            #data = self.database.animals.find( {}, {"_id": False})
        #return data
        
        #return dataset else error

    def update(self, searchData, updateData):
        if searchData is not None:
            result = self.database.animals.update_many(searchData, { "$set": updateData })
        else:
            return "{}"
        return result.raw_result
        #update record specified, if error then return blank
    
    def delete(self, deleteData):
        if deleteData is not None:
            result = self.database.animals.delete_many(deleteData)
        else:
            return "{}"
        return result.raw_result
        #delete data record specified, else return error
    
                
import pandas as pd
import numpy as np
import json
import clipboard as c
import requests

values = []
num = 500



minCounter = 99821
# Old 51245
busCounter = 0
errorStack = []
property = "business"
url = "http://www.joshuapulido.com:8080/api/v1/addbusiness"

def process_business(businessStr):
    global busCounter, errorStack
    businessJSON = json.loads(businessStr)
    businessID = businessJSON['business_id']
    name = businessJSON['name']
    count = businessJSON['review_count']
    stars = businessJSON['stars']
    category = businessJSON['categories']
    busCounter += 1


    jsonUpload = {
        "businessId": businessID,
        "name": name,
        "reviewCount": count,
        "stars": stars,
        "category": category
    }
    #print(json)

    r = requests.post(url, json=jsonUpload)

    #})

    if r.status_code != 200:
        print("Error ocurred at " + str(busCounter))
        errorStack.append(businessStr)

def print_json(businessStr):
    global busCounter, errorStack
    businessJSON = json.loads(businessStr)
    businessID = businessJSON['business_id']
    name = businessJSON['name']
    count = businessJSON['review_count']
    stars = businessJSON['stars']
    category = businessJSON['categories']
    busCounter += 1


    jsonUpload = {
        "businessId": businessID,
        "name": name,
        "reviewCount": count,
        "stars": stars,
        "category": category
    }
    print(jsonUpload)

with open('yelp_academic_dataset_{prop}.json'.format(prop=property),'r',encoding='utf-8') as f:
    while line := f.readline():
        if busCounter >= minCounter:
            process_business(line)
        #elif busCounter >= minCounter - 20 and busCounter < minCounter:
            #print_json(line)
            #busCounter += 1
        else:
            busCounter += 1

print(busCounter)
print(errorStack)

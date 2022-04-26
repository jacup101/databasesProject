import numpy as np
import json
import clipboard as c
import requests
import pprint
import asyncio
import aiohttp

values = []
num = 500



minCounter = 99821
# Old 51245
busCounter = 0
errorStack = []
property = "user"
url = "http://www.joshuapulido.com:8080/api/v1/adduser"

def get_json(userStr):
    userJSON = json.loads(userStr)
    userID = userJSON['user_id']
    name = userJSON['name']
    count = userJSON['reviewCount']
    # busCounter += 1


    jsonUpload = {
        "userId": userID,
        "name": name,
        "reviewCount": count
    }

    return jsonUpload
    # print(jsonUpload)



async def make_posts(jsons, nums):
    async with aiohttp.ClientSession() as session:
        for i in range(len(jsons)):
            async with session.post(url, json=jsons[i]) as resp:
                test = await resp.json()
                print(test)




bundleCounter = 0
bundleJSONs = []
bundleJSONsNums = []
bundleNum = 0
bundleSize = 40
numCounter = 0
maxAmount =  10000   # 20000
pp = pprint.PrettyPrinter(width=41, compact=True)
# yelp_academic_dataset_{prop}.json
with open('dummy_users.json'.format(prop=property),'r',encoding='utf-8') as f:
    while line := f.readline():
        bundleCounter += 1
        numCounter += 1
        bundleJSONs.append(get_json(line))
        bundleJSONsNums.append(bundleCounter)

        if bundleCounter == bundleSize or numCounter == maxAmount:
            print("Bundle # " + str(bundleNum))
            # pp.pprint(bundleJSONs)
            asyncio.run(make_posts(bundleJSONs, bundleJSONsNums))
            print("HEY WHERE AM I")

            # handle_bundleJSONs()

            # Reset bundleCounter and bundleJSONs
            bundleNum += 1
            bundleCounter = 0
            bundleJSONs = []
        if numCounter == maxAmount:
            break


        #if busCounter >= minCounter:
        #    process_business(line)
        #elif busCounter >= minCounter - 20 and busCounter < minCounter:
            #print_json(line)
            #busCounter += 1
        #else:
        #    busCounter += 1

print(numCounter)

print(busCounter)
print(errorStack)

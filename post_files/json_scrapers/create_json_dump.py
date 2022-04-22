import requests
import random
import string
import names

numUsers = 20000
finalString = ""

for i in range(numUsers):
    dummyName = names.get_full_name()
    letters = string.ascii_letters
    busID = ''.join(random.choice(letters) for i in range(22))
    business_id = busID
    review_count = random.randint(0,10000)


    finalString += '{"user_id": "' + busID + '", "name": "' + dummyName + '", "review_count": '+ str(review_count) + '}\n'



with open('./dummy_users.json', 'w') as f:
    f.write(finalString)

#r = requests.post(url, json={
#    "userId": business_id,
#    "name": name,
#    "reviewCount": review_count
#})
#print(f"Status Code: {r.status_code}, Response: {r.json()}")

import requests
import random
import string


url = "http://www.joshuapulido.com:8080/api/v1/adduser"



# printing letters
letters = string.ascii_letters
busID = ''.join(random.choice(letters) for i in range(22))


business_id = busID
review_count = random.randint(0,10000)
print("Select a name")
name = input()


r = requests.post(url, json={
    "userId": business_id,
    "name": name,
    "reviewCount": review_count
})
print(f"Status Code: {r.status_code}, Response: {r.json()}")

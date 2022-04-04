import requests
import random
import string


url = "http://www.joshuapulido.com:8080/api/v1/addbusiness"



# printing letters
letters = string.ascii_letters
busID = ''.join(random.choice(letters) for i in range(22))


business_id = busID
review_count = random.randint(0,10000)
print("Select a name")
name = input()
categoryChoice = ["Fast Food", "Pub", "Casino", "something", "random data", "nuclear powerplant", "game design studio", "computer repair shop",
"prison", "Library 15", "Mcdonald's", "taqueria"]
category = random.choice(categoryChoice)
starsChoices = [0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0]
stars = random.choice(starsChoices)




r = requests.post(url, json={
    "businessId": business_id,
    "name": name,
    "reviewCount": review_count,
    "stars": stars,
    "category": category
})
print(f"Status Code: {r.status_code}, Response: {r.json()}")
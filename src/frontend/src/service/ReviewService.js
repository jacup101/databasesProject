// const BUSINESS_API = 'http://147.182.246.194:8080/api/v1/';
const BUSINESS_API = 'http://localhost:8080/api/v1/';

class ReviewService {
    getReviews(){
        return fetch(BUSINESS_API + 'reviews/',{
            mode: 'cors',
            method: 'get',
                headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
                },
                'credentials': 'same-origin'
        })
        .then(res => res.json());
    }

    getReviews_by_keyword(keyword){
        return fetch(BUSINESS_API + "find_review_by_keyword/" + keyword,{
            mode: 'cors',
            method: 'get',
                headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
                },
                'credentials': 'same-origin'
        })
        .then(res => res.json());
    }

}

export default new ReviewService();

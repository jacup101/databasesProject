const BUSINESS_API = 'http://147.182.246.194:8080/api/v1/';
class BusinessService {
    getBusinesses(){
        return fetch(BUSINESS_API + 'all_businesses',{
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

    getBusinesses_by_keyword(keyword){
        return fetch(BUSINESS_API + "find_business_by_keyword/" + keyword,{
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

    getBusinesses_by_id(id){
        return fetch(BUSINESS_API + 'businesses/' + id,{
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

export default new BusinessService();

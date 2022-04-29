import React from 'react';
import BusinessService from '../service/BusinessService';

class BusinessComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            businesses:[],
            search:''
        }
    }

    componentDidMount(){
      BusinessService.getBusinesses().then((data) => {
            this.setState({ businesses: data })
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });
    }

    //Search Box Method
    searchBox = (e) => {
        this.setState({
            //assigning value to event target
            [e.target.name]:e.target.value,
        });
    };
    //Search Method Logic
    searchBusiness = () => {
      BusinessService.getBusinesses_by_keyword(this.state.search).then((data) => {
            console.log(data)
            this.setState({ businesses: data })
            console.log(this.state.businesses)
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });
    };
    //Reset Search Box
    resetBusiness = () =>{
        this.setState({"search":''});
    };

    render(){
    return(
      <div>
      <div className="container mt-2">
        <div style={{float: 'left', marginBottom:'10px'}} align="center">
        <div className="form-group mb-2">
            <input type="text" className="form-control" name="search" size="50"  placeholder="Search Here" value={this.state.search}  onChange={this.searchBox}/>
            <button type="button" name="search" className="btn btn-info my-2 text-center mr-2" onClick={this.searchBusiness}>Search</button>
            <button type="reset" className="btn btn-secondary text-center ml-5" style={{marginRight:'10px'}} onClick={this.resetBusiness}>Clear</button>
        </div>
      </div>
      </div>
        <table className="styled-table">
            <thead>
                <tr>
                    <th>Business Id</th>
                    <th>Business Name</th>
                    <th>Business Category</th>
                </tr>
            </thead>
            <tbody>
                {this.state.businesses.length===0?
                <tr align="center">
                    <td colSpan="5">No Record Found</td>
                </tr>
                :
                this.state.businesses.map(
                (business) =>(
                // replace the books with businesses, change the controller for the new query
                <tr key = {business.businessId}>
                    <td>{business.businessId}</td>
                    <td>{business.name}</td>
                    <td>{business.category}</td>
                </tr>
                )
                )
                }
            </tbody>
        </table>
    </div>
    )
}

}

export default BusinessComponent

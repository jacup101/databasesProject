import React from 'react';
import BusinessService from '../service/BusinessService';
import BusinessComponent from './BusinessComponent'

class SearchbarComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
          businesses:[],
          search:''
        }
    }

    handleNameChange = item => {
    this.setState({ item })
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
            this.setState({ businesses: data })
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
              <div style={{float: 'center'}} align="center">
              <div className="form-group mb-2">
                  <input type="text" className="form-control" name="search" size="50"  placeholder="Search Here" value={this.state.search}  onChange={this.searchBox}/>
                  <button type="button" name="search" className="btn btn-info my-2 text-center mr-2" onClick={this.searchBusiness}>Search Business</button>
                  <button type="reset" className="btn btn-secondary text-center ml-5" style={{marginLeft:'10px'}} onClick={this.resetBusiness}>Clear Business</button>
              </div>
            </div>
            </div>
          </div>
        )
    }
}

export default SearchbarComponent

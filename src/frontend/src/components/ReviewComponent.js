import React from 'react';
import ReviewService from '../service/ReviewService';
import BusinessService from '../service/BusinessService';

class ReviewComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            reviews:[],
            businesses:{},
            business_holder:{},
            search:''
        }
    }

    componentDidMount(){
      ReviewService.getReviews().then((data) => {
            this.setState({ reviews: data })
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });
      this.updateBusinesses();
    }

    updateBusinesses = () => {
      this.state.reviews.map((review) =>(
        BusinessService.getBusinesses_by_id(review.id).then((data) => {
              this.tempObj = this.businesses
              this.tempObj[review.id] = data.name
              this.setState({ businesses: this.tempObj })
            })
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex)
            })
      ));
    };

    //Search Box Method
    searchBox = (e) => {
        this.setState({
            //assigning value to event target
            [e.target.name]:e.target.value,
        });
    };
    //Search Method Logic
    searchReview = () => {
      ReviewService.getReviews_by_keyword(this.state.search).then((data) => {
            this.setState({ reviews: data })
            this.updateBusinesses()
          })
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });
    };
    //Reset Search Box
    resetReview = () =>{
        this.setState({"search":''});
    };

    // handleInputChange = event => {
    //    this.props.onNameChange(event.target.value)
    //  }

    render(){
    return(
      <div>
      <div className="container mt-2">
        <div style={{float: 'left', marginBottom:'10px'}} align="center">
        <div className="form-group mb-2">
            <input type="text" className="form-control" name="search" size="50"  placeholder="Search Here" value={this.state.search}  onChange={this.searchBox}/>
            <button type="button" name="search" className="btn btn-info my-2 text-center mr-2" onClick={this.searchReview}>Search</button>
            <button type="reset" className="btn btn-secondary text-center ml-5" style={{marginRight:'10px'}} onClick={this.resetReview}>Clear</button>
        </div>
      </div>
      </div>
        <table className="styled-table">
            <thead>
                <tr>
                    <th>Review Id</th>
                    <th>Review Date</th>
                    <th>Review Text</th>
                    <th>Business</th>
                </tr>
            </thead>
            <tbody>
                {this.state.reviews.length===0?
                <tr align="center">
                    <td colSpan="5">No Record Found</td>
                </tr>
                :
                this.state.reviews.map(
                (review) =>(
                // replace the books with reviews, change the controller for the new query
                <tr key = {review.reviewId}>
                    <td>{review.reviewId}</td>
                    <td>{review.date}</td>
                    <td>{review.text}</td>
                    <td>{review.businessId}</td>
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

export default ReviewComponent

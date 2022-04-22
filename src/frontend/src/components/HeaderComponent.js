import React from 'react';

class HeaderComponent extends React.Component {

    constructor(props){
        super(props)
    };

    // componentDidMount(){
    //   BusinessService.getBusinesses().then((data) => {
    //         console.log(data)
    //         this.setState({ businesses: data })
    //         console.log(this.state.businesses)
    //       })
    //       .catch(function (ex) {
    //           console.log('Response parsing failed. Error: ', ex);
    //       });
    // };

    render(){
      return(
        <div>
          <div className="header">
            <a href="#default" className="logo">Yalp</a>
            <div className="header-right">
              <a className="active" href="#home">Home</a>
              <a href="#contact">Contact</a>
              <a href="#about">About</a>
            </div>
          </div>
        </div>
      )
    }

}

export default HeaderComponent

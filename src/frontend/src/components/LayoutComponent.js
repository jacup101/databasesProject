import React from 'react';
import '../style/Layout.css';
import ad from '../images/ad.png'; // Tell webpack this JS file uses this image
import BusinessComponent from './BusinessComponent'
// import SearchbarComponent from './SearchbarComponent.js';

class LayoutComponent extends React.Component {

    render(){
      return(
        <div>
          <div className="row">
              <div className="sideColumn">
                  <div className="topic">
                  <a href="https://www.dominos.com/">
                  <img src={ad} alt="Dominoes Pizza"/>
                  </a>
                  </div>
              </div>
              <div className="midColumn">
                <div className="topic">
                    <p>Businesses</p>
                    <BusinessComponent />
                    </div>
              </div>
          </div>
      </div>
      )
    }

}

export default LayoutComponent

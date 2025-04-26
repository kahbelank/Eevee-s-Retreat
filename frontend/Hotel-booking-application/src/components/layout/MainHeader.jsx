/* eslint-disable no-unused-vars */
import React from "react"
import { Link } from "react-router-dom"

const MainHeader = () => {
	return (
		<div className="main-header">
			{/* Text Container Above the Banner */}
			<div className="header-text">
				<h1>
					<span className="hotel-color2"> Giving the best <br />
					just for you</span>
				</h1>
				
			</div>
			{/* <Link to={"/browse-all-rooms"} className="hotel-color3">
				Browse all rooms
			</Link> */}
			
			{/* Banner with Image and Overlay */}
			<header className="header-banner">
				<div className="overlay"></div>
			</header>
		</div>
	)
}

export default MainHeader

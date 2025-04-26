/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
import React from "react"

const Header = ({ title }) => {
	return (
		<header className="header">
			
			<div className="container">
				<h1 className="header-title text-center ">{title}</h1>
			</div>
		</header>
	)
}

export default Header

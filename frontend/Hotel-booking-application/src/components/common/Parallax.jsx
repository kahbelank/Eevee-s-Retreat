/* eslint-disable no-unused-vars */
/* eslint-disable react/no-unescaped-entities */
import React from "react"
import { Container } from "react-bootstrap"

const Parallax = () => {
	return (
		<div className="parallax">
			<Container className="text-center px-5 py-5 justify-content-center">
				<div className="animated-texts bounceIn">
					<h1>
						Experience the Best hospitality at <span>Eevee's Retreat</span>
					</h1>
					<h3>We offer the best services for all your needs.</h3>
				</div>
			</Container>
		</div>
		
	)
}

export default Parallax

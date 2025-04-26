/* eslint-disable no-unused-vars */
/* eslint-disable react/no-unescaped-entities */
import React from "react"
import { Container, Row, Col, Card } from "react-bootstrap"
import Header from "./Header"
import {
	FaClock,
	FaCocktail,
	FaParking,
	FaSnowflake,
	FaTshirt,
	FaUtensils,
	FaWifi
} from "react-icons/fa"

const HotelService = () => {
	return (
		<>
			<div className="mb-2" style={{ backgroundColor: "white" }}>
				<Header title={"Our Services"} />

				<Row className="mt-4" style={{ paddingLeft: "0px" }}>
					<h4 className="text-center">
						Services at <span> Eevee's Retreat - </span>
						<span className="gap-2">
							<FaClock className="ml-5" /> 24-Hour Front Desk
						</span>
					</h4>
				</Row>
				<hr />

				<Row xs={1} md={2} lg={3} className="g-4 mt-2" style={{ paddingLeft: "40px", paddingRight: "40px" , paddingBottom: "30px"}}>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaWifi /> WiFi
								</Card.Title>
								<Card.Text>Stay connected with high-speed internet access.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaUtensils /> Breakfast
								</Card.Title>
								<Card.Text>Start your day with a delicious breakfast buffet.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaTshirt /> Laundry
								</Card.Title>
								<Card.Text>Keep your clothes clean and fresh with our laundry service.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaCocktail /> Mini-bar
								</Card.Title>
								<Card.Text>Enjoy a refreshing drink or snack from our in-room mini-bar.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaParking /> Parking
								</Card.Title>
								<Card.Text>Park your car conveniently in our on-site parking lot.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
					<Col>
						<Card>
							<Card.Body>
								<Card.Title className="hotel-colortext">
									<FaSnowflake /> Air conditioning
								</Card.Title>
								<Card.Text>Stay cool and comfortable with our air conditioning system.</Card.Text>
							</Card.Body>
						</Card>
					</Col>
				</Row>
			</div>
			
		</>
	)
}

export default HotelService

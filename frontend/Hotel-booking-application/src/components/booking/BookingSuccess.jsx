import React from "react"
import { Link, useLocation } from "react-router-dom"
import Header from "../common/Header"

const BookingSuccess = () => {
	const location = useLocation()
	const message = location.state?.message
	const error = location.state?.error
	return (
		<div className="container-fluid"  style={{ backgroundColor: "white", marginLeft:"0px", paddingLeft:"0px", paddingRight:"0px" }}>
			<Header title="Booking Success" />
			<div className="mt-5" style={{ backgroundColor: "white", paddingLeft:"0px", paddingRight:"0px", textAlign:"center" }}>
				{message ? (
					<div>
						<h3 className="text-success"> Booking Success!</h3>
						<p className="text-success" style={{ paddingBottom:"100%", paddingRight:"0px", textAlign:"center" }}>{message}</p>
					</div>
				) : (
					<div>
						<h3 className="text-danger"> Error Booking Room!</h3>
						<p className="text-danger">{error}</p>
						
					</div>
				)}
			</div>
		</div>
	)
}

export default BookingSuccess

import React from "react"
import { Link } from "react-router-dom"

const Admin = () => {
	return (
		<section className="container mt-5" style={{ backgroundColor: "white", paddingLeft:"50px", paddingRight:"50px", paddingBottom:"50px", borderRadius: "15px" }}>
			<h2 style={{ paddingTop: "25px" }}>Welcome to Admin Panel</h2>
			<hr />
			<Link to={"/existing-rooms"}>Manage Rooms</Link> <br />
			<Link to={"/existing-bookings"}>Manage Bookings</Link>
		</section>
	)
}

export default Admin

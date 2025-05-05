# 🏨 Eevee’s Retreat - Hotel Booking and Management System  

## Team Members 
1. Ho Zheng Wei 
2. Izz Danial Bin Selamat
3. James Nicolas Tan Cher Wei 
4. Kahbelan Kalisalvam Kelaver 


## 📌 Project Overview  
Eevee’s Retreat is a **web-based hotel booking system** designed to provide a **seamless, efficient, and secure** reservation experience for both customers and hotel staff. Customers can **browse available rooms, check availability, book their stay, and manage their reservations effortlessly**.  

The system also includes an **admin dashboard** where hotel staff can **manage room availability, pricing, and customer bookings**.  

## 🚀 Features  

### 🔹 **Customer Features**
- 📅 **Room Booking** – Browse available rooms, check prices, and make reservations.  
- 📄 **Booking Management** – Modify or cancel bookings before check-in.  
- 🔒 **User Authentication** – Secure login and registration using JWT-based authentication.  
- 🛎 **Facility & Amenity Reservations** – Book additional hotel amenities like spa, gym, and conference rooms.  
- 📧 **Email Notifications** – Booking confirmations and updates sent via email.  

### 🔹 **Admin Features**
- 🏠 **Room Management** – Add, edit, and remove hotel rooms.  
- 📋 **Booking Overview** – Manage customer reservations with approval or cancellation options.  
- 📊 **Dashboard Analytics** – View hotel occupancy, revenue, and booking trends.  
- 🔐 **Role-Based Access Control (RBAC)** – Admins, managers, and customers have different access permissions.  
- 📄 **Reports & Logs** – Generate booking and financial reports.  

---

## 🏗️ Tech Stack  
| **Layer**       | **Technology**          |
|----------------|------------------------|
| **Frontend**   | React.js, Bootstrap 5  |
| **Backend**    | Spring Boot (Java)     |
| **Database**   | MySQL                   |
| **Authentication** | JWT (JSON Web Token) |
| **Deployment** | AWS (EC2, RDS) / Docker |
| **CI/CD**      | GitHub Actions, Jenkins |

---

## 📁 Project Structure  

<pre>
eevees-retreat/
├── frontend/               # React.js application
│   ├── src/               # React components and pages
│   ├── public/            # Static files (images, assets)
│   ├── package.json       # Frontend dependencies
│   └── README.md
├── backend/               # Spring Boot application
│   ├── src/main/          # Java source files
│   ├── src/test/          # Unit tests
│   ├── pom.xml            # Maven dependencies
│   └── README.md
├── docs/                  # Documentation (UML diagrams, API specs)
│   ├── architecture.md  
│   ├── api-specs.md
│   ├── sprint-reports/
├── scripts/               # Deployment scripts
├── .github/               # GitHub workflows (CI/CD)
├── .env.example           # Environment variables template
├── docker-compose.yml     # Docker setup
├── LICENSE                # License file
└── README.md              # Project documentation
</pre>




## 📜 API Documentation  
Some of the potential API Documentation:
The backend API follows **RESTful principles**.  

### **User Authentication API**  
| Method | Endpoint           | Description        | Required Role |
|--------|-------------------|-------------------|--------------|
| POST   | `/auth/register`  | Register new user | Public |
| POST   | `/auth/login`     | Authenticate user | Public |
| GET    | `/users/profile`  | Fetch user profile | Authenticated |

### **Room Booking API**  
| Method | Endpoint              | Description          | Required Role |
|--------|----------------------|---------------------|--------------|
| GET    | `/rooms`             | List available rooms | Public |
| POST   | `/bookings`          | Create new booking  | Customer |
| GET    | `/bookings/{id}`     | View booking details | Customer |
| DELETE | `/bookings/{id}`     | Cancel booking      | Customer/Admin |

## 🎯 Installation Guide  

### **Prerequisites**
Ensure you have the following installed:  
- **Node.js (v18+)**  
- **Java 17+**  
- **Maven**  
- **MySQL Server**  
- **Docker** (for containerized deployment)  
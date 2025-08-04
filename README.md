## 📮 API Endpoints

### 👨‍⚕️ Doctor (Employee)

| Method | Endpoint                         | Description                         |
|--------|----------------------------------|-------------------------------------|
| GET    | `/doctors`                       | Get all doctors                     |
| GET    | `/doctors/{id}`                  | Get a doctor by ID                  |
| GET    | `/doctors/status/{status}`       | Get doctors by status (`ON`, `OFF`) |
| GET    | `/doctors/department/{dept}`     | Get doctors by department           |

---

### 🧑‍🦽 Patient

| Method | Endpoint                                          | Description                                                   |
|--------|---------------------------------------------------|---------------------------------------------------------------|
| GET    | `/patients`                                       | Get all patients                                              |
| GET    | `/patients/{id}`                                  | Get patient by ID                                             |
| GET    | `/patients/dob?start=YYYY-MM-DD&end=YYYY-MM-DD`   | Get patients born in a date range                             |
| GET    | `/patients/department/{dept}`                     | Get patients admitted by doctors from a specific department   |
| GET    | `/patients/doctor-status/off`                     | Get patients admitted by doctors whose status is `OFF`        |

---

### This project includes a SQL script to manually insert initial data into the database.

### Location:
src/main/resources/db/seed-data.sql

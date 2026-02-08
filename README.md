# Agent Service

A lightweight Spring Boot pilot project that exposes a conversational appointment assistant using Spring AI's ChatClient and a small in-memory domain model for doctors, patients and appointments.

**Project purpose:** provide a Chat-based appointment agent that can use small tools (get doctors, create patient, book appointment) and demonstrate how to integrate tools with `ChatClient`.

**Quick summary**
- **Main app:** `AgentServiceApplication` (Spring Boot starter)
- **Controller:** `ChartBotController` — HTTP endpoint for chat queries
- **Chat client config:** `ChatClientConfig` — builds `ChatClient` and registers tools
- **Tools:** `DoctorTools`, `PatientTools` — annotated `@Tool` methods exposed to the chat client
- **Services & data:** `DoctorService`, `PatientService`, `AppointmentService` with in-memory storage

**Endpoints**
- GET `/chart-boot/appointment-agent?query={text}`
  - Forwards `{text}` to the configured `ChatClient` prompt and returns the agent response.
  - Example:

```bash
curl -G --data-urlencode "query=List available cardiologists and book an appointment for John Doe on 2026-02-09 10 AM" http://localhost:8080/chart-boot/appointment-agent
```

**Tools available to the ChatClient**
- `getDoctors` — returns a list of sample `Doctor` objects (from `DoctorDataLoader`).
- `addPatient` — accepts a `Patient` object, creates a patient in memory, and returns the saved `Patient`.
- `getPatient` — accepts a phone number (string) and returns the `Patient` if found.
- `bookAppointment` — accepts an `Appointment` object (see model below) and returns a `Map` with `success`, `appointmentId`, `scheduledTime`, `doctorName`.




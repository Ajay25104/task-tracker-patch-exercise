# Notes

I fixed issues in backend search and request handling, and frontend request state.

- In [backend/src/main/java/com/internal/tasktracker/TaskRepository.java](backend/src/main/java/com/internal/tasktracker/TaskRepository.java), I grouped the JPQL title/description matches so archived and optional status filters apply correctly.
- I updated [backend/src/main/java/com/internal/tasktracker/TaskController.java](backend/src/main/java/com/internal/tasktracker/TaskController.java) to handle invalid status and pagination inputs safely, and removed an artificial delay.
- In [frontend/src/hooks/useTasks.js](frontend/src/hooks/useTasks.js), I fixed request loading/error state resets. In [frontend/src/App.jsx](frontend/src/App.jsx), I reset pagination when search or status changes.
- I restored port 8080 in [backend/src/main/resources/application.properties](backend/src/main/resources/application.properties) and [frontend/vite.config.js](frontend/vite.config.js) so the backend and proxy match the README.

I did not change the app design or database schema because the identified issues were in query logic, request handling, and configuration.

The biggest remaining risk is that the app uses a small in-memory H2 dataset and is not production-hardened for security or scale.

I used GitHub Copilot to help inspect and patch the code, then reviewed the changes and checked them against the README. The repository regression test and frontend build passed; the backend started on port 8080 and its sample search endpoint returned task data.

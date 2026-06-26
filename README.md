# SQL Generator

SQL Generator is a Chrome extension that converts natural language into SQL queries using AI. It is designed to help students, developers, and SQL learners generate SQL queries quickly without manually writing complex syntax.

The project uses a Spring Boot backend integrated with the Groq API to process user prompts and generate SQL queries. It also includes secure user authentication, query history management, and a clean Chrome extension interface.

## Features

- Convert natural language into SQL queries using Groq LLM
- User registration and login with JWT authentication
- Secure password storage using BCrypt
- View user-specific query history
- Delete individual history records
- Download query history
- Copy generated SQL
- Insert generated SQL directly into SQL editors
- Dark and Light mode support

## Technologies Used

**Backend**
- Java
- Spring Boot
- Spring Security
- JWT
- BCrypt
- MySQL
- REST API

**Frontend**
- HTML
- CSS
- JavaScript
- Chrome Extension (Manifest V3)

**AI**
- Groq API (Llama 3)

## How It Works

1. The user enters a prompt in the Chrome extension.
2. The request is sent to the Spring Boot backend.
3. The backend forwards the prompt to the Groq API.
4. The generated SQL query is returned to the extension.
5. The query is displayed and stored in the logged-in user's history.

## Project Highlights

- AI-powered SQL generation
- Secure authentication using JWT
- BCrypt password encryption
- User-specific history management
- Individual history deletion
- Download history as a text file
- Chrome Extension integration

## Future Improvements

- SQL formatting
- Query search
- Favorite queries
- Cloud deployment
- Support for additional AI models

## Author

Varshini Muchu

# KPI Dashboard Example

This repository contains a simple Java Spring Boot application that displays KPI metrics calculated from a sample CSV file.
The metrics follow the requirements defined in `SRS.md`, including averages for completion rate and various test and quality indicators across all projects.

## Setup

Ensure you have Java and Maven installed.

Install the project dependencies and build the application:

```bash
mvn package
```

## Running the dashboard

```bash
mvn spring-boot:run
```

Then open `http://localhost:8080` in your browser. The dashboard uses the CSV file at `src/main/resources/data/kpi_data.csv` to show aggregated metrics.

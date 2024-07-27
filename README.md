# FreshMate

## Project Overview

FreshMate is a grocery tracking system designed to optimize household food management by tracking the expiration dates of grocery items, sending timely notifications as items near expiration, and suggesting recipes using nearly expired food items. This system aims to reduce food waste, enhance meal planning, and provide convenience for users in managing their groceries.

## Team Members

- Antony Benitez
- Albert Ng
- Ashraf Sangi
- Jessalyn Otero
- Mike Odnis

## Initial Project Proposal

### Project Goals

- Reduce food waste by tracking expiration dates of grocery items.
- Provide timely notifications to users as items near their expiration dates.
- Suggest recipes using nearly expired food items.
- Enhance meal planning and provide nutritional guidance.

### Features

- **User Profiles**: Create personalized profiles to manage food items and preferences.
- **Expiration Tracking**: Enter and track the expiration dates of grocery items.
- **Notifications**: Receive reminders via push notifications, emails, or SMS when items are nearing expiration.
- **Recipe Suggestions**: Access a variety of recipes that incorporate ingredients close to expiring.
- **Nutritional Information** (Optional): View nutritional guidance and meal planning options.
- **List View**: Display items nearing expiration, sorted from soonest to latest.

## WRSPM Analysis

### World Assumptions

- Users purchase a variety of perishable food items with expiration dates.
- Users have access to smart devices with internet connectivity.
- Users possess basic technical knowledge and an interest in reducing food waste.

### User Requirements

- **Ease of Use**: A user-friendly interface for easy navigation and data entry.
- **Timely Notifications**: Alerts when items are nearing their expiration dates.
- **Reminder Notice Date Options**: Ability to set reminder notice dates (e.g., 1 day or 1 week before expiration).
- **Personalized Profiles**: Create profiles and set food recipe preferences.
- **Recipe Suggestions**: Access to recipes using ingredients close to expiring.
- **Nutritional Guidance**: Options for nutritional guidance and meal planning.
- **Data Security**: Secure storage and protection of user data.
- **Cross-Platform Accessibility**: Access via multiple devices (smartphones, tablets, desktops).

### Specifications and Interface Needs

- **Responsive Design**: Accessible across smartphones, tablets, and desktops.
- **User Authentication**: Robust authentication for secure access.
- **Notification System**: Customizable settings for reminder notices.
- **Nutritional Guidance**: Options for nutritional guidance and meal planning.
- **Health Tracking Integration** (Optional): Integration with health tracking devices for comprehensive recommendations.
- **Cross-Platform Support**: Compatibility with major operating systems (iOS, Android, Windows, macOS).
- **User Interface**: Clean and intuitive for easy logging of food items, reminders, and recipe access.

## Design

Our project's user interface design can be viewed on Figma. Check out our design mockups and prototypes:

[FreshMate Figma Design](https://www.figma.com/design/1cKKrQhbILP9d0Dsg8g4M1/Fresh-Mate?node-id=0-1&t=d5XCYiYzjVIcckNH-1)

## Program and Hardware

- **Development Platform**: JavaFX for desktop applications.
- **Data Storage**: Firebase for real-time data storage and retrieval.
- **Notification Management**: Firebase Cloud Messaging for sending alerts.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- JavaFX
- Firebase account for database and cloud messaging setup

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Jessalynnic/CSC325_FreshMate_Project.git freshmate
   ```

2. Navigate to the project directory:

   ```bash
   cd freshmate
   ```

3. Set up Firebase:
   - Create a Firebase project and add your web app.
   - Copy the Firebase configuration and initialize Firebase in your project.
4. Run the application:

   ```bash
   ./gradlew run
   ```

## Contributing

1. Fork the repository.
2. Create a new branch:

   ```bash
   git checkout -b feature-branch
   ```

3. Make your changes and commit them:

   ```bash
   git commit -m "Description of your changes"
   ```

4. Push to the branch:

   ```bash
   git push origin feature-branch
   ```

5. Create a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any questions or concerns, please contact the project team:

- [Antony Benitez](mailto://beniax@farmingdale.edu)
- [Albert Ng](mailto://nga9@farmingdale.edu)
- [Ashraf Sangi](mailto://sanga31@farmingdale.edu)
- [Jessalyn Otero](mailto://oterjn@farmingdale.edu)
- [Mike Odnis](mailto://odnims@farmingdale.edu)

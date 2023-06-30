# We don't want to start from scratch.
# That is why we tell node here to use the current node image as base.
FROM node:19.5.0-alpine

# Create an application directory
RUN mkdir -p /app

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY Front-End/package*.json ./

# Install node packages
RUN NODE_ENV=development npm i

# Copy or project directory (locally) in the current directory of our docker image (/app)
COPY Front-End/ .

# Start the app
CMD [ "npm", "run", "dev" ]
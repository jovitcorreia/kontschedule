FROM node:14.17.6-alpine as build
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . ./
ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}
RUN npm run build

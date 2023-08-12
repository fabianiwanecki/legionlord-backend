FROM nginx:1.15.8
EXPOSE 80
COPY docker/frontend/config/default.conf /etc/nginx/conf.d/
RUN rm -rf /usr/share/nginx/html/*
COPY dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
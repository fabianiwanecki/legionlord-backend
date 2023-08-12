upstream legionlord {
    server legionlord-backend:9090;
}

upstream frontend {
    server legionlord-frontend:5100;
}

server {
    listen 80;
    listen [::]:80;
    server_name api.legionlord.com www.api.legionlord.com;

    location ~ /.well-known/acme-challenge {
        allow all;
        root /var/www/html;
    }
}



server {
    listen 5100 ssl;
    server_name api.legionlord.com www.api.legionlord.com;

    ssl_certificate     /etc/letsencrypt/live/api.legionlord.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/api.legionlord.com/privkey.pem;

    location / {
        proxy_pass  http://localhost:5100;
    }
}
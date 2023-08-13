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
    listen 443 ssl;
    server_name api.legionlord.com www.api.legionlord.com;

    ssl_certificate     /etc/letsencrypt/live/api.legionlord.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/api.legionlord.com/privkey.pem;

    location / {
        proxy_pass http://backend:10010;
        proxy_set_header Host $host:$server_port;
        proxy_set_header X-Forwarded-Host $server_name;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
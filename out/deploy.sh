#!/bin/bash
sudo rm -r /var/www/html/*
sudo cp -r * /var/www/html
sudo chmod 777 /var/www/html/images
echo Deployed.

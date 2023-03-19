FROM node:16.14.0

WORKDIR /docker

COPY ./.next ./.next
COPY ./node_modules ./node_modules
COPY ./package* ./

CMD ["npm", "run", "start"]
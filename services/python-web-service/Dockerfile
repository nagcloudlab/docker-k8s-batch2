FROM python:3.12.2-alpine3.19
ARG FILE_NAME=foo.py
RUN apk update && apk add curl
WORKDIR /app
COPY $FILE_NAME requirements.txt ./
RUN pip install -r requirements.txt
ENTRYPOINT ["gunicorn", "--bind", "0.0.0.0:8080", "app:app"]
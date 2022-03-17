#Step 0: Choose base
FROM openjdk:11

# install google chrome
RUN apt-get update && apt-get install -y gnupg2 wget ca-certificates curl lsb-release software-properties-common
RUN echo "Instalando Google Chrome"
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get -y update
RUN apt-get install -y google-chrome-stable

#RUN sed -i 's,exec -a "$0" "$HERE/chrome" "$@",exec -a "$0" "$HERE/chrome" "$@" --user-data-dir --test-type --no-sandbox --headless,g' /usr/bin/google-chrome
#RUN sed -i 's,exec -a "$0" "$HERE/chrome" "$@",exec -a "$0" "$HERE/chrome" "$@" --user-data-dir --test-type --no-sandbox --headless,g' /usr/bin/google-chrome-stable

# install chromedriver
RUN echo "Instalando Chrome WebDriver"
RUN apt-get install -yqq unzip
RUN wget -O /tmp/chromedriver.zip http://chromedriver.storage.googleapis.com/`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`/chromedriver_linux64.zip
RUN unzip /tmp/chromedriver.zip chromedriver -d /usr/local/bin/

#Install Maven
RUN apt install maven -y

# Copy our project
COPY . /app
#Making our working directory as /app
WORKDIR /app
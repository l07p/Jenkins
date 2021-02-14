# Settings

## python

first of all, install pip. Install it as root, it works for all other users include jenkins

``sudo apt update``

``sudo apt install python3-pip``

| plugins | note |
|---------|------|
| see follows | - |

``python3 -m pip install psycopg2``

``python3 -m pip install gspread oauth2client``

``python3 -m pip install mail-parser``

``python3 -m pip install pdfminer``

``python3 -m pip install pdfminer.six``

``python3 -m pip install pandas``

### problems: install psycopg2 failed

sudo apt-get update

sudo apt-get install libpq-dev python3.8-dev

pipenv install --python=3.8 psycopg2

pipenv shell

then, pip install psycopg2 again!!!

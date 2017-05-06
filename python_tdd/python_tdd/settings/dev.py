from .base import *

DEBUG = True

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, '../python_tdd_database/db.sqlite3'),
    }
}

ALLOWED_HOSTS = ['tdd.lazylife.ml']

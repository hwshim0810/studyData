from django.conf.urls import url
from lists.views import *

urlpatterns = [
    url(r'(\d+)/$', view_list, name='view_list'),
    url(r'^new$', new_list, name='new_list'),
]

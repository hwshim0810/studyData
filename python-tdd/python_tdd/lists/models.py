from django.db import models
from django.core.urlresolvers import reverse


class List(models.Model):
    # 특정 url 에 연계될 model obj 의 주소를 반환할 특수 method
    def get_absolute_url(self):
        return reverse('view_list', args=[self.id])


class Item(models.Model):
    text = models.TextField(default='')
    list = models.ForeignKey(List, default=None)


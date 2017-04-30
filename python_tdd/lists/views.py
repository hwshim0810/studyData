from django.shortcuts import render, redirect
from django.http import HttpResponse

from lists.models import Item, List


def index(request):
    return render(request, 'lists/index.html')


def view_list(request):
    items = Item.objects.all()
    return render(request, 'lists/list.html', {'items': items})


def new_list(request):
    list_ = List.objects.create()
    Item.objects.create(text=request.POST['task'], list=list_)
    return redirect('/lists/the-only-one/')

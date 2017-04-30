from django.shortcuts import render, redirect
from django.http import HttpResponse

from lists.models import Item


def index(request):
    if request.method == 'POST':
        Item.objects.create(text=request.POST['task'])
        return redirect('/')

    items = Item.objects.all()
    return render(request, 'lists/index.html', {'items': items})

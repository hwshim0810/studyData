from django.shortcuts import render, redirect
from django.core.exceptions import ValidationError

from lists.models import Item, List
from lists.forms import ItemForm


def index(request):
    return render(request, 'lists/index.html', {'form': ItemForm})


def view_list(request, list_id):
    list_ = List.objects.get(id=list_id)
    form = ItemForm()
    if request.method == 'POST':
        form = ItemForm(data=request.POST)
        if form.is_valid():
            Item.objects.create(text=request.POST.get('task', False), list=list_)
            return redirect(list_)
    return render(request, 'lists/list.html', {'list': list_, 'form': form})


def new_list(request):
    form = ItemForm(data=request.POST)
    if form.is_valid():
        list_ = List.objects.create()
        Item.objects.create(text=request.POST.get('task', False), list=list_)
        # obj 의 전달로 특수 method 를 호출함
        return redirect(list_)
    else:
        return render(request, 'lists/index.html', {'form': form})



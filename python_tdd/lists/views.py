from django.shortcuts import render, redirect
from django.core.exceptions import ValidationError

from lists.models import Item, List


def index(request):
    return render(request, 'lists/index.html')


def view_list(request, list_id):
    list_ = List.objects.get(id=list_id)
    error = None
    if request.method == 'POST':
        try:
            item = Item.objects.create(text=request.POST.get('task', False), list=list_)
            item.full_clean()
            item.save()
            return redirect(list_)
        except ValidationError:
            error = "빈 아이템 리스트를 기질 수 없다"
    return render(request, 'lists/list.html', {'list': list_, 'error': error})


def new_list(request):
    list_ = List.objects.create()
    item = Item.objects.create(text=request.POST.get('task', False), list=list_)
    try:
        item.full_clean()
        item.save()
    except ValidationError:
        list_.delete()
        error = "빈 아이템 리스트를 기질 수 없다"
        return render(request, 'lists/index.html', {'error': error})
    # obj 의 전달로 특수 method 를 호출함
    return redirect(list_)


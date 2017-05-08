from django import forms

from lists.models import Item


EMPTY_LIST_ERROR = "빈 아이템 리스트를 기질 수 없다"


class ItemForm(forms.models.ModelForm):
    class Meta:
        model = Item
        fields = ('text',)
        widgets = {
            'text': forms.fields.TextInput(attrs={
                'placeholder': '작업 입력',
                'class': 'form-control input-lg',
            }),
        }
        # 기본 유효성 에러메세지를 교체
        error_messages = {
            'text': {'required': EMPTY_LIST_ERROR}
        }

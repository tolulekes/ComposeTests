package com.vog.mvvmdemo.ui.feedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vog.mvvmdemo.general.Event
import com.vog.mvvmdemo.models.Feedback
import com.vog.mvvmdemo.models.IFeedbackModel
import com.vog.mvvmdemo.models.Subject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedbackViewModel(private val model: IFeedbackModel): ViewModel() {
    enum class EventType{SUBMIT, CANCEL}

    private val _event = MutableLiveData<Event<EventType>>()
    val event: LiveData<Event<EventType>> get() = _event
    fun onEvent(eventType: EventType) {
        _event.value = Event(eventType)
    }

    private val _subjects = MutableLiveData<List<Subject>>()
    val subjects: LiveData<List<Subject>> get() = _subjects
    private fun setSubjects(v: List<Subject>) {
        _subjects.value = v
    }

    private val _subject = MutableLiveData<Subject>()
    val subject: LiveData<Subject> get() = _subject
    fun setSubject(v: Subject) {
        _subject.value = v
    }

    private val _subSubject = MutableLiveData<Subject>()
    val subSubject: LiveData<Subject> get() = _subSubject
    fun setSubSubject(v: Subject) {
        _subSubject.value = v
    }

    val message = MutableLiveData<String>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val subjects = model.getSubjects()
            withContext(Dispatchers.Main){
                setSubjects(subjects)
            }
        }
    }

    fun submitFeedback(){
        CoroutineScope(Dispatchers.IO).launch {
            model.submitFeedback(
                Feedback(
                    subject = subject.value,
                    subSubject = subSubject.value,
                    message = message.value
            ))
        }
    }

}
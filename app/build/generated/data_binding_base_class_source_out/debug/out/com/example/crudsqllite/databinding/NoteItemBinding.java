// Generated by view binder compiler. Do not edit!
package com.example.crudsqllite.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.crudsqllite.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NoteItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView deleteNote;

  @NonNull
  public final TextView txtContent;

  @NonNull
  public final TextView txtTitle;

  @NonNull
  public final ImageView updateNote;

  private NoteItemBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView deleteNote,
      @NonNull TextView txtContent, @NonNull TextView txtTitle, @NonNull ImageView updateNote) {
    this.rootView = rootView;
    this.deleteNote = deleteNote;
    this.txtContent = txtContent;
    this.txtTitle = txtTitle;
    this.updateNote = updateNote;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NoteItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NoteItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.note_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NoteItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delete_note;
      ImageView deleteNote = ViewBindings.findChildViewById(rootView, id);
      if (deleteNote == null) {
        break missingId;
      }

      id = R.id.txt_content;
      TextView txtContent = ViewBindings.findChildViewById(rootView, id);
      if (txtContent == null) {
        break missingId;
      }

      id = R.id.txt_title;
      TextView txtTitle = ViewBindings.findChildViewById(rootView, id);
      if (txtTitle == null) {
        break missingId;
      }

      id = R.id.update_note;
      ImageView updateNote = ViewBindings.findChildViewById(rootView, id);
      if (updateNote == null) {
        break missingId;
      }

      return new NoteItemBinding((ConstraintLayout) rootView, deleteNote, txtContent, txtTitle,
          updateNote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
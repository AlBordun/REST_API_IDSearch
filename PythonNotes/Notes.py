import json
import datetime

class Note:
    def __init__(self, title, body):
        self.title = title
        self.creation_date = datetime.datetime.now()
        self.modification_date = self.creation_date
        self.body = body[:2000]

    def update_body(self, new_body):
        self.body = new_body[:2000]
        self.modification_date = datetime.datetime.now()

class NoteApp:
    def __init__(self, file_path):
        self.file_path = file_path
        self.notes = self._load_notes()

    def _load_notes(self):
        try:
            with open(self.file_path, "r") as file:
                notes_data = json.load(file)
                return [Note(note['title'], note['body']) for note in notes_data]
        except FileNotFoundError:
            return []

    def _save_notes(self):
        notes_data = [{'title': note.title, 'body': note.body} for note in self.notes]
        with open(self.file_path, "w") as file:
            json.dump(notes_data, file, indent=4)

    def add_note(self, title, body):
        new_note = Note(title, body)
        self.notes.append(new_note)
        self._save_notes()

    def update_note_body(self, note_idx, new_body):
        if 0 <= note_idx < len(self.notes):
            self.notes[note_idx].update_body(new_body)
            self._save_notes()

    def delete_note(self, note_idx):
        if 0 <= note_idx < len(self.notes):
            del self.notes[note_idx]
            self._save_notes()

    def get_note_list(self):
        return [
            f"Title: {note.title}, "
            f"Creation Date: {note.creation_date}, "
            f"Modification Date: {note.modification_date}, "
            f"Body: {note.body[:100]}"
            for note in self.notes
        ]

def print_notes(notes):
    if len(notes) == 0:
        print("No notes found.")
    else:
        for note in notes:
            print(note)

def main():
    file_path = "notes.json"
    note_app = NoteApp(file_path)

    while True:
        print("\nSelect an option:")
        print("1. Add a note")
        print("2. Update a note")
        print("3. Delete a note")
        print("4. View all notes")
        print("5. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            title = input("Enter note title: ")
            body = input("Enter note body: ")
            note_app.add_note(title, body)
            print("Note added successfully.")

        elif choice == "2":
            notes = note_app.get_note_list()
            print_notes(notes)
            note_idx = int(input("Enter the index of the note to update: "))
            new_body = input("Enter new note body: ")
            note_app.update_note_body(note_idx, new_body)
            print("Note updated successfully.")

        elif choice == "3":
            notes = note_app.get_note_list()
            print_notes(notes)
            note_idx = int(input("Enter the index of the note to delete: "))
            note_app.delete_note(note_idx)
            print("Note deleted successfully.")

        elif choice == "4":
            notes = note_app.get_note_list()
            print_notes(notes)

        elif choice == "5":
            print("Exiting the application.")
            break

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
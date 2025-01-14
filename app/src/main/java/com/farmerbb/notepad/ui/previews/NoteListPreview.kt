/* Copyright 2021 Braden Farmer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.farmerbb.notepad.ui.previews

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.farmerbb.notepad.R
import com.farmerbb.notepad.models.NoteMetadata
import com.farmerbb.notepad.ui.content.NoteListContent
import com.farmerbb.notepad.ui.widgets.AppBarText
import com.farmerbb.notepad.ui.widgets.MoreButton
import java.util.Date

@Composable
private fun NoteList(notes: List<NoteMetadata>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { AppBarText(stringResource(id = R.string.app_name)) },
                backgroundColor = colorResource(id = R.color.primary),
                actions = {
                    MoreButton()
                }
            )
        },
        content = {
            NoteListContent(notes)
        }
    )
}

@Preview
@Composable
fun NoteListPreview() = MaterialTheme {
    NoteList(
        notes = listOf(
            NoteMetadata(
                metadataId = -1,
                title = "Test Note 1",
                date = Date()
            ),
            NoteMetadata(
                metadataId = -1,
                title = "Test Note 2",
                date = Date()
            )
        )
    )
}

@Preview
@Composable
fun NoteListEmptyPreview() = MaterialTheme {
    NoteList(notes = emptyList())
}

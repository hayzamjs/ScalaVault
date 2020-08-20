/*
 * Copyright (c) 2017 m2049r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ////////////////
 *
 * Copyright (c) 2020 Scala
 *
 * Please see the included LICENSE file for more information.*/

package io.scalaproject.vault.fragment.send;

import androidx.fragment.app.Fragment;

import io.scalaproject.vault.layout.SpendViewPager;

abstract public class SendWizardFragment extends Fragment
        implements SpendViewPager.OnValidateFieldsListener {

    @Override
    public boolean onValidateFields() {
        return true;
    }

    public void onPauseFragment() {
    }

    public void onResumeFragment() {
    }
}

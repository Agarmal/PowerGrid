/*
 * Copyright 2026 patryk3211
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
package org.patryk3211.powergrid.compat.computercraft;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import dev.architectury.platform.Platform;

import java.util.function.Function;

public class ComputerCraftBridge {
    private static Function<SmartBlockEntity, ComputerBehaviour> factory;

    private static void modLoaded() {
        factory = ComputerBehaviourImpl::new;
    }

    public static void init() {
        factory = NoComputerBehaviour::new;
        if(Platform.isModLoaded("computercraft")) {
            modLoaded();
        }
    }

    public static ComputerBehaviour create(SmartBlockEntity be) {
        return factory.apply(be);
    }
}

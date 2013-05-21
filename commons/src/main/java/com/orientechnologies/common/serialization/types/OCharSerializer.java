/*
 * Copyright 2010-2012 Luca Garulli (l.garulli--at--orientechnologies.com)
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

package com.orientechnologies.common.serialization.types;

import java.nio.ByteOrder;

import com.orientechnologies.common.directmemory.ODirectMemory;
import com.orientechnologies.common.serialization.OBinaryConverter;
import com.orientechnologies.common.serialization.OBinaryConverterFactory;

/**
 * 
 * @author ibershadskiy <a href="mailto:ibersh20@gmail.com">Ilya Bershadskiy</a>
 * @since 18.01.12
 */
public class OCharSerializer implements OBinarySerializer<Character> {
  private static final OBinaryConverter BINARY_CONVERTER = OBinaryConverterFactory.getConverter();

  /**
   * size of char value in bytes
   */
  public static final int               CHAR_SIZE        = 2;

  public static OCharSerializer         INSTANCE         = new OCharSerializer();
  public static final byte              ID               = 3;

  public int getObjectSize(final Character object) {
    return CHAR_SIZE;
  }

  public void serialize(final Character object, final byte[] stream, final int startPosition) {
    stream[startPosition] = (byte) (object >>> 8);
    stream[startPosition + 1] = (byte) (object.charValue());
  }

  public Character deserialize(final byte[] stream, final int startPosition) {
    return (char) (((stream[startPosition] & 0xFF) << 8) + (stream[startPosition + 1] & 0xFF));
  }

  public int getObjectSize(final byte[] stream, final int startPosition) {
    return CHAR_SIZE;
  }

  public byte getId() {
    return ID;
  }

  public int getObjectSizeNative(byte[] stream, int startPosition) {
    return CHAR_SIZE;
  }

  public void serializeNative(Character object, byte[] stream, int startPosition) {
    BINARY_CONVERTER.putChar(stream, startPosition, object, ByteOrder.nativeOrder());
  }

  public Character deserializeNative(byte[] stream, int startPosition) {
    return BINARY_CONVERTER.getChar(stream, startPosition, ByteOrder.nativeOrder());
  }

  @Override
  public void serializeInDirectMemory(Character object, ODirectMemory memory, long pointer) {
    memory.setChar(pointer, object);
  }

  @Override
  public Character deserializeFromDirectMemory(ODirectMemory memory, long pointer) {
    return memory.getChar(pointer);
  }

  @Override
  public int getObjectSizeInDirectMemory(ODirectMemory memory, long pointer) {
    return CHAR_SIZE;
  }

  public boolean isFixedLength() {
    return true;
  }

  public int getFixedLength() {
    return CHAR_SIZE;
  }
}

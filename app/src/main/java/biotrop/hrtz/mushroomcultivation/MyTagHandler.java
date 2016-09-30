package biotrop.hrtz.mushroomcultivation;

/*
 * Copyright (C) 2016 Matthias Stevens for InThePocket.mobi
 * Copyright (C) 2013-2015 Juha Kuitunen
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
        import android.text.Editable;
        import android.text.Html;
        import android.text.style.BulletSpan;
        import android.text.style.LeadingMarginSpan;

        import org.xml.sax.XMLReader;

        import java.util.ArrayList;
        import java.util.List;

public class MyTagHandler implements Html.TagHandler
{
    private int  m_index  = 0;
    private List< String > m_parents   = new ArrayList< String >( );

    @Override
    public void handleTag( final boolean opening, final String tag, Editable output, final XMLReader xmlReader )
    {
        if( tag.equals( "ul" ) || tag.equals( "ol" ) || tag.equals( "dd" ) )
        {
            if( opening )
            {
                m_parents.add( tag );
            }
            else m_parents.remove( tag );

            m_index = 0;
        }
        else if( tag.equals( "li" ) && !opening ) handleListTag( output );
    }

    private void handleListTag( Editable output )
    {
        if( m_parents.get(m_parents.size()-1 ).equals( "ul" ) )
        {
            output.append( "\n" );
            String[ ] split = output.toString( ).split( "\n" );

            int lastIndex = split.length - 1;
            int start = output.length( ) - split[ lastIndex ].length( ) - 1;
            output.setSpan( new BulletSpan( 15 * m_parents.size( ) ), start, output.length( ), 0 );
        }
        else if( m_parents.get(m_parents.size()-1).equals( "ol" ) )
        {
            m_index++ ;

            output.append( "\n" );
            String[ ] split = output.toString( ).split( "\n" );

            int lastIndex = split.length - 1;
            int start = output.length( ) - split[ lastIndex ].length( ) - 1;
            output.insert( start, m_index + ". " );
            output.setSpan( new LeadingMarginSpan.Standard(0, 20 * m_parents.size( ) ), start, output.length( ), 0 );
        }
    }
}